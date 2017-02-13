package com.example.ea.domain;

/**
 * Created by padrisimo on 13/02/2017.
 */

public enum Region {
    Portugal_Asturies("The Portuguese Asturies"), Southern_Asturies("Southern Asturies"), Tierrina("La Tierrina"), Santillana("Asturies de Santillana");
    private String label;
    private Region(String label) {
        this.label = label;
    }
    public static Region findByLabel(String byLabel) {
        for(Region r: Region.values()) {
            if (r.label.equalsIgnoreCase(byLabel))
                return r;
        }
        return null;
    }
}
