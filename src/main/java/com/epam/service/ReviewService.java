package com.epam.service;

import com.epam.entity.Review;
import com.epam.entity.enums.Appraisal;
import com.epam.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface ReviewService extends BaseService<Review> {

    /**
     * Finds all reviews related to the film
     *
     * @param id the primary key of table 'movie'
     * @return reviews wrapped in a {@link List}
     * @throws ServiceException if {@code DAOException} occurs
     */
    List<Review> findAllByMovieId(Integer id) throws ServiceException;

    /**
     * Finds all comments left by the user
     *
     * @param id the primary key of table 'user'
     * @return reviews wrapped in a {@link List}
     * @throws ServiceException if {@code DAOException} occurs
     */
    List<Review> findAllByUserId(Integer id) throws ServiceException;

    /**
     * Creates and returns autogenerated (@code Review) id
     *
     * @param text      a review content
     * @param appraisal the number of stars set {@link Appraisal}
     * @return {@code true} if this is the first user comment on this movie, {@code false} otherwise
     * @throws ServiceException if {@code DAOException} occurs
     */
    boolean create(String text, Appraisal appraisal, Integer movieId, Integer userId) throws ServiceException;

    /**
     * Returns user feedback to the movie with {@param movie_id}
     *
     * @param userId  the primary key of table 'user'
     * @param movieId the primary key of table 'movie'
     * @return the review wrapped in an {@link Optional}
     * @throws ServiceException if {@code DaoException} occurs
     */
    Optional<Review> findByMovieIdUserId(Integer movieId, Integer userId) throws ServiceException;

    /**
     * Finds the average rating of a movie
     *
     * @param id the primary key of table 'movie'
     * @return {@link Double} - average score
     * @throws ServiceException if {@code DaoException} occurs
     */
    Double getAverageRating(Integer id) throws ServiceException;

    /**
     * The method is used by the administrator.
     * Removes the user's comment for a specific movie.
     *
     * @return {@code true} if the review has been deleted, {@code false} otherwise
     * @throws ServiceException if {@code DaoException} occurs
     */
    boolean deleteByMovieIdUserId(Integer movieId, Integer userId) throws ServiceException;
}
