package com.lmorda.explore.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lmorda.domain.DataRepository
import com.lmorda.explore.list.ExploreContract.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ExploreViewModel(
    private val dataRepository: DataRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(State(isFirstLoad = true))
    val state: StateFlow<State> = _state

    init {
        getNextPage()
    }

    fun onRefresh() {
        _state.value = State(isRefreshing = true)
        getNextPage()
    }

    fun getNextPage() {
        viewModelScope.launch {
            try {
                if (state.value.page > 0) {
                    _state.update { it.copy(isFetchingNextPage = true) }
                }
                val repos = dataRepository.getRepos(page = state.value.page + 1)
                _state.update {
                    it.hideLoading().copy(
                        githubRepos = it.githubRepos + repos,
                        page = state.value.page + 1,
                    )
                }
            } catch (ex: Exception) {
                _state.update { it.hideLoading().copy(exception = ex) }
            }
        }
    }
}
