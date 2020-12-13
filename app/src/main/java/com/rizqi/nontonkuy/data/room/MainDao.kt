package com.rizqi.nontonkuy.data.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.rizqi.nontonkuy.data.model.Movie
import com.rizqi.nontonkuy.data.model.Tv

@Dao
interface MainDao {

  @Query("SELECT * FROM movies")
  fun getMovies(): DataSource.Factory<Int, Movie>


  @Query("SELECT * FROM tvs")
  fun getTvs(): DataSource.Factory<Int, Tv>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertMovies(movies: List<Movie>)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertTvs(tvs: List<Tv>)

  @Update
  fun updateMovie(movie: Movie)

  @Update
  fun updateTv(tv: Tv)

  @Query("SELECT * FROM movies where bookmarked = 1")
  fun getBookmarkedMovie(): DataSource.Factory<Int, Movie>

  @Query("SELECT * FROM tvs where bookmarked = 1")
  fun getBookmarkedTv(): DataSource.Factory<Int, Tv>

  @Query("SELECT * FROM movies WHERE id = :movieId")
  fun getMovieById(movieId: String): LiveData<List<Movie>>

  @Query("SELECT * FROM tvs WHERE id = :tvId")
  fun getTvById(tvId: String): LiveData<List<Tv>>

    // @Query("SELECT * FROM courseentities")
    // fun getCourses(): DataSource.Factory<Int, CourseEntity>

    // @Query("SELECT * FROM courseentities where bookmarked = 1")
    // fun getBookmarkedCourse(): DataSource.Factory<Int, CourseEntity>

    // @Transaction
    // @Query("SELECT * FROM courseentities WHERE courseId = :courseId")
    // fun getCourseWithModuleById(courseId: String): LiveData<CourseWithModule>

    // @Insert(onConflict = OnConflictStrategy.REPLACE)
    // fun insertCourses(courses: List<CourseEntity>)

    // @Update
    // fun updateCourse(course: CourseEntity)

    // @Query("SELECT * FROM moduleentities WHERE courseId = :courseId")
    // fun getModulesByCourseId(courseId: String): LiveData<List<ModuleEntity>>

    // @Query("SELECT * FROM moduleentities WHERE moduleId = :moduleId")
    // fun getModuleById(moduleId: String): LiveData<ModuleEntity>

    // @Insert(onConflict = OnConflictStrategy.REPLACE)
    // fun insertModules(module: List<ModuleEntity>)

    // @Update
    // fun updateModule(module: ModuleEntity)

    // @Query("UPDATE moduleentities SET content = :content WHERE moduleId = :moduleId")
    // fun updateModuleByContent(content: String, moduleId: String)
}
