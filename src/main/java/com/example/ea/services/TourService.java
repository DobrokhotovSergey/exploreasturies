package com.example.ea.services;

import com.example.ea.domain.Difficulty;
import com.example.ea.domain.Region;
import com.example.ea.domain.Tour;
import com.example.ea.domain.TourPackage;
import com.example.ea.repo.TourPackageRepository;
import com.example.ea.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by padrisimo on 14/02/2017
 */
@Service
public class TourService {
    private TourPackageRepository tourPackageRepository;
    private TourRepository tourRepository;

    @Autowired
    public TourService(TourPackageRepository tourPackageRepository, TourRepository tourRepository) {
        this.tourPackageRepository = tourPackageRepository;
        this.tourRepository = tourRepository;
    }

    public Tour createTour(String title, String description, String blurb, Integer price, String duration,
                           String bullets, String keywords, String tourPackageCode, Difficulty difficulty,
                           Region region) {
        TourPackage tourPackage = tourPackageRepository.findOne(tourPackageCode);
        if (tourPackage == null) {
            throw new RuntimeException(("El tour package no existe: " + tourPackageCode));
        }
        return tourRepository.save(new Tour(title, description, blurb, price, duration, bullets,
                keywords, tourPackage, difficulty, region));
    }
    public Iterable<Tour> lookup() {
        return tourRepository.findAll();
    }
    public long total(){
        return tourRepository.count();
    }
}