package com.rizqi.nontonkuy.data

import androidx.paging.DataSource
import com.rizqi.nontonkuy.data.model.Movie
import com.rizqi.nontonkuy.data.model.Tv
import com.rizqi.nontonkuy.data.room.MainDao

class LocalDataSource private constructor(private val mMainDao: MainDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(mainDao: MainDao): LocalDataSource {
            if (INSTANCE == null) {
                INSTANCE = LocalDataSource(mainDao)
            }
            return INSTANCE as LocalDataSource
        }
    }

    fun getAllMovies(): DataSource.Factory<Int, Movie> = mMainDao.getMovies()

    fun getAllTvs(): DataSource.Factory<Int, Tv> = mMainDao.getTvs()

    fun getBookmarkedMovies(): DataSource.Factory<Int, Movie> = mMainDao.getBookmarkedMovie()

    fun getBookmarkedTvs(): DataSource.Factory<Int, Tv> = mMainDao.getBookmarkedTv()

    fun insertMovies(movies: List<Movie>) = mMainDao.insertMovies(movies)

    fun insertTvs(tvs: List<Tv>) = mMainDao.insertTvs(tvs)

    fun setMovieBookmarked (movie: Movie, newState: Boolean) {
        movie.bookmarked = newState
        mMainDao.updateMovie(movie)
    }

    fun setTvBookmarked (tv: Tv, newState: Boolean) {
        tv.bookmarked = newState
        mMainDao.updateTv(tv)
    }

//    fun updateMovie(content: String, moduleId: String) {
//        mMainDao.updateModuleByContent(content, moduleId)
//    }

//    fun getAllCourses(): DataSource.Factory<Int, CourseEntity> = mMainDao.getCourses()

//    fun getBookmarkedCourses(): DataSource.Factory<Int, CourseEntity> =
//            mMainDao.getBookmarkedCourse()

//    fun getCourseWithModules(courseId: String): LiveData<CourseWithModule> =
//            mMainDao.getCourseWithModuleById(courseId)

//    fun getAllModulesByCourse(courseId: String): LiveData<List<ModuleEntity>> =
//            mMainDao.getModulesByCourseId(courseId)

//    fun insertCourses(courses: List<CourseEntity>) {
//        mMainDao.insertCourses(courses)
//    }

//    fun insertModules(modules: List<ModuleEntity>) {
//        mMainDao.insertModules(modules)
//    }

//    fun setCourseBookmark(course: CourseEntity, newState: Boolean) {
//        course.bookmarked = newState
//        mMainDao.updateCourse(course)
//    }

//    fun getModuleWithContent(moduleId: String): LiveData<ModuleEntity> =
//            mMainDao.getModuleById(moduleId)

//    fun updateContent(content: String, moduleId: String) {
//        mMainDao.updateModuleByContent(content, moduleId)
//    }

//    fun setReadModule(module: ModuleEntity) {
//        module.read = true
//        mMainDao.updateModule(module)
//    }
}