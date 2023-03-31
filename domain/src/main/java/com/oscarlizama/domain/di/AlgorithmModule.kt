package com.oscarlizama.domain.di

import com.oscarlizama.domain.algorithms.bubblesort.BubbleSort
import com.oscarlizama.domain.algorithms.insertionsort.InsertionSort
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AlgorithmModule {

    @Provides
    @Singleton
    fun provideInsertionSortAlgorithm(): InsertionSort = InsertionSort()

    @Provides
    @Singleton
    fun provideBubbleSortAlgorithm(): BubbleSort = BubbleSort()

}