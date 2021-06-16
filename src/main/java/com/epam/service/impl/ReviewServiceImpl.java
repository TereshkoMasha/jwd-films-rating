package com.epam.service.impl;

import com.epam.dao.impl.ReviewDaoImpl;
import com.epam.entity.Review;
import com.epam.exception.DAOException;
import com.epam.service.ReviewService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class ReviewServiceImpl implements ReviewService {
    private static final Logger LOGGER = LogManager.getLogger(ReviewService.class);
    private static final ReviewDaoImpl reviewDao = ReviewDaoImpl.INSTANCE;

    @Override
    public List<Review> findAll() {
        List<Review> reviewList = null;
        try {
            reviewList = reviewDao.findAll();
            if (!reviewList.isEmpty()) {
                return reviewList;
            }
        } catch (DAOException e) {
            LOGGER.error(e);
        }
        return reviewList;
    }

    @Override
    public Optional<Review> getById(Integer id) {
        try {
            Optional<Review> optionalReview = reviewDao.getById(id);
            if (optionalReview.isPresent()) {
                return optionalReview;
            }
        } catch (DAOException e) {
            LOGGER.error(e);
        }
        return Optional.empty();
    }

    @Override
    public boolean update(Review entity) {
        return reviewDao.update(entity);
    }

    @Override
    public boolean deleteById(Integer id) {
        return reviewDao.deleteById(id);
    }

    @Override
    public List<Review> findAllByMovieId(Integer id) {
        List<Review> reviewList = null;
        try {
            reviewList = reviewDao.findAllByMovieId(id);
            if (!reviewList.isEmpty()) {
                return reviewList;
            }
        } catch (DAOException e) {
            LOGGER.error(e);
        }
        return reviewList;
    }
}