package com.sorabh.expression_calculator.di.modul

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sorabh.expression_calculator.data.repo.NetworkRepository
import com.sorabh.expression_calculator.data.repo.NetworkRepositoryImpl
import com.sorabh.expression_calculator.data.repo.RoomDBRepository
import com.sorabh.expression_calculator.data.repo.RoomDBRepositoryImpl
import com.sorabh.expression_calculator.data.room.ExpressionDB
import com.sorabh.expression_calculator.data.room.ExpressionDao
import com.sorabh.expression_calculator.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Singleton
    @Provides
    fun provideNetworkRepo(networkRepository: NetworkRepositoryImpl): NetworkRepository =
        networkRepository

    @Singleton
    @Provides
    fun provideRoomDB(@ApplicationContext context: Context):ExpressionDB =
        Room.databaseBuilder(
            context.applicationContext,
            ExpressionDB::class.java,
            Constants.EXPRESSION_DB_NAME
        ).build()

    @Singleton
    @Provides
    fun provideRoomDao(expressionDB: ExpressionDB):ExpressionDao = expressionDB.expressionDao()

    @Singleton
    @Provides
    fun provideRoomBbRepo(roomDBRepository: RoomDBRepositoryImpl):RoomDBRepository = roomDBRepository


}