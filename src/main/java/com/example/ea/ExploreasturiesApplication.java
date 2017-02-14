package com.example.ea;

import com.example.ea.services.TourPackageService;
import com.example.ea.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExploreasturiesApplication implements CommandLineRunner{

	@Autowired
	private TourPackageService tourPackageService;
	@Autowired
	private TourService tourService;

	public static void main(String[] args) {
		SpringApplication.run(ExploreasturiesApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		//Create the default tour packages
		tourPackageService.createTourPackage("BA", "Backpack Ast");
		tourPackageService.createTourPackage("AC", "Asturies Calm");
		tourPackageService.createTourPackage("AH", "Asturies Hot springs");
		tourPackageService.createTourPackage("CY", "Cycle Asturies");
		tourPackageService.createTourPackage("MS", "From Montain to Sea");
		tourPackageService.createTourPackage("KA", "Kids Asturies");
		tourPackageService.createTourPackage("NW", "Nature Watch");
		tourPackageService.createTourPackage("SA", "Snowboard Asturies");
		tourPackageService.createTourPackage("TA", "Taste of Asturias");
		tourPackageService.lookup().forEach(tourPackage -> System.out.println(tourPackage));

	}
}
