package com.sisrawat.mobile.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sisrawat.mobile.data.remote.response.DataDoktersItem
import com.sisrawat.mobile.data.remote.retrofit.ApiService
import retrofit2.HttpException
import java.io.IOException

class DokterPagingSource(private val apiService: ApiService): PagingSource<Int, DataDoktersItem>() {
    override fun getRefreshKey(state: PagingState<Int, DataDoktersItem>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataDoktersItem> {
        return try {
            val currentPage = params.key ?: 1
            val dokters = apiService.getAllDokter(currentPage)

            LoadResult.Page(
                data = dokters.dataDokters,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (dokters.dataDokters.isEmpty()) null else dokters.currentPage + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}