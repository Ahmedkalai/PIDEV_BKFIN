package com.BKFIN.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class unemployedpopulation  {
		
		@Id
		@Column(name="Population_id")
		private Long Population_id;
		
		@Column(name="Regions")
		private String Regions;
		
		@Column(name="environment")
		private String environment;
		
		@Column(name="Sexe")
		private String Sexe;
		
		@Column(name="Distribution_of_population")
		private Long Distribution_of_population;
		
		@Column(name="number_houses")
		private Long number_houses;
		
		@Column(name="less_than_1Km")
		private Long less_than_1Km;
		
		@Column(name="Between_1KM_2Km")
		private Long Between_1KM_2Km;
		
		@Column(name="Plus2Km")
		private Long Plus2Km;
		
		@Column(name="Population_aged_15_and_plus")
		private Long Population_aged_15_and_plus;
		
		@Column(name="active_Population_Occupied")
		private Long active_Population_Occupied;
		
		@Column(name="Inactive_Population")
		private Long Inactive_Population;
		
		@Column(name="activity_rate")
		private float activity_rate;
		
		@Column(name="Unemployment_rate")
		private float Unemployment_rate;
		
		@Column(name="Unemployed_Neant")
		private Long Unemployed_Neant;
		
		@Column(name="Unemployed_Primary")
		private Long Unemployed_Primary;
		
		@Column(name="Unemployed_Secondary")
		private Long Unemployed_Secondary;
		
		
		@Column(name="Unemployed_faculty")
		private Long Unemployed_faculty;
		
		@Column(name="Unemployed_Agriculture_fishing")
		private Long Unemployed_Agriculture_fishing;
		
		@Column(name="Unemployed_Mines_energy")
		private Long Unemployed_Mines_energy;
		
		@Column(name="Unemployed_manufacturing_Industry")
		private Long Unemployed_manufacturing_Industry;
		
		@Column(name="Unemployed_Building_public_works")
		private Long Unemployed_Building_public_works;
		
		@Column(name="Unemployed_Commerce")
		private Long Unemployed_Commerce;
		
		@Column(name="Unemployed_Transport")
		private Long Unemployed_Transport;
		
		@Column(name="Unemployed_Education_health_administrative_services")
		private Long Unemployed_Education_health_administrative_services;
		
		@Column(name="Unemployed_Other_services")
		private Long Unemployed_Other_services;
		
		@Column(name="Unemployed_Undeclared")
		private Long Unemployed_Undeclared;
		
		@Column(name="Unemployed_15_19_years_Age")
		private Long Unemployed_15_19_years_Age;
		
		@Column(name="Unemployed_20_24_years_Age")
		private Long Unemployed_20_24_years_Age;
		
		@Column(name="Unemployed_25_29_years_Age")
		private Long Unemployed_25_29_years_Age;
		
		@Column(name="Unemployed_30_34_years_Age")
		private Long Unemployed_30_34_years_Age;
		
		@Column(name="Unemployed_35_39_years_Age")
		private Long Unemployed_35_39_years_Age;
		
		@Column(name="Unemployed_40_44_years_Age")
		private Long Unemployed_40_44_years_Age;
		
		@Column(name="Unemployed_45_49_years_Age")
		private Long Unemployed_45_49_years_Age;
		
		@Column(name="Unemployed_50_59_years_Age")
		private Long Unemployed_50_59_years_Age;
		
		@Column(name="Unemployed_60plus_years")
		private Long Unemployed_60plus_years;
		
		public static String[] fields() {
			return new String[] {
					"Population_id", "Regions", "environment", "Sexe",
			    	"Distribution_of_population","number_houses","less_than_1Km","Between_1KM_2Km",
			    	"Plus2Km","Population_aged_15_and_plus","active_Population_Occupied","Inactive_Population",
			    	 "activity_rate","Unemployment_rate","Unemployed_Neant",
			    		"Unemployed_Primary","Unemployed_Secondary","Unemployed_faculty","Unemployed_Agriculture_fishing",
			    		"Unemployed_Mines_energy","Unemployed_manufacturing_Industry","Unemployed_Building_public_works",
			    		"Unemployed_Commerce","Unemployed_Transport","Unemployed_Education_health_administrative_services",
			    		"Unemployed_Other_services","Unemployed_Undeclared","Unemployed_15_19_years_Age",
			    		"Unemployed_20_24_years_Age","Unemployed_25_29_years_Age","Unemployed_30_34_years_Age",
			    		"Unemployed_35_39_years_Age","Unemployed_40_44_years_Age","Unemployed_45_49_years_Age",
			    		"Unemployed_50_59_years_Age","Unemployed_60plus_years"
			};
		}
		

		public unemployedpopulation(Long population_id, String regions, String environment, String sexe,
				Long distribution_of_population, Long number_houses, Long less_than_1Km, Long between_1km_2Km,
				Long plus2Km, Long population_aged_15_and_plus, Long active_Population_Occupied,
				Long inactive_Population, float activity_rate, float unemployment_rate, Long unemployed_Neant,
				Long unemployed_Primary, Long unemployed_Secondary, Long unemployed_faculty,
				Long unemployed_Agriculture_fishing, Long unemployed_Mines_energy,
				Long unemployed_manufacturing_Industry, Long unemployed_Building_public_works, Long unemployed_Commerce,
				Long unemployed_Transport, Long unemployed_Education_health_administrative_services,
				Long unemployed_Other_services, Long unemployed_Undeclared, Long unemployed_15_19_years_Age,
				Long unemployed_20_24_years_Age, Long unemployed_25_29_years_Age, Long unemployed_30_34_years_Age,
				Long unemployed_35_39_years_Age, Long unemployed_40_44_years_Age, Long unemployed_45_49_years_Age,
				Long unemployed_50_59_years_Age, Long unemployed_60plus_years) {
			super();
			Population_id = population_id;
			Regions = regions;
			this.environment = environment;
			Sexe = sexe;
			Distribution_of_population = distribution_of_population;
			this.number_houses = number_houses;
			this.less_than_1Km = less_than_1Km;
			Between_1KM_2Km = between_1km_2Km;
			Plus2Km = plus2Km;
			Population_aged_15_and_plus = population_aged_15_and_plus;
			this.active_Population_Occupied = active_Population_Occupied;
			Inactive_Population = inactive_Population;
			this.activity_rate = activity_rate;
			Unemployment_rate = unemployment_rate;
			Unemployed_Neant = unemployed_Neant;
			Unemployed_Primary = unemployed_Primary;
			Unemployed_Secondary = unemployed_Secondary;
			Unemployed_faculty = unemployed_faculty;
			Unemployed_Agriculture_fishing = unemployed_Agriculture_fishing;
			Unemployed_Mines_energy = unemployed_Mines_energy;
			Unemployed_manufacturing_Industry = unemployed_manufacturing_Industry;
			Unemployed_Building_public_works = unemployed_Building_public_works;
			Unemployed_Commerce = unemployed_Commerce;
			Unemployed_Transport = unemployed_Transport;
			Unemployed_Education_health_administrative_services = unemployed_Education_health_administrative_services;
			Unemployed_Other_services = unemployed_Other_services;
			Unemployed_Undeclared = unemployed_Undeclared;
			Unemployed_15_19_years_Age = unemployed_15_19_years_Age;
			Unemployed_20_24_years_Age = unemployed_20_24_years_Age;
			Unemployed_25_29_years_Age = unemployed_25_29_years_Age;
			Unemployed_30_34_years_Age = unemployed_30_34_years_Age;
			Unemployed_35_39_years_Age = unemployed_35_39_years_Age;
			Unemployed_40_44_years_Age = unemployed_40_44_years_Age;
			Unemployed_45_49_years_Age = unemployed_45_49_years_Age;
			Unemployed_50_59_years_Age = unemployed_50_59_years_Age;
			Unemployed_60plus_years = unemployed_60plus_years;
		}

		public unemployedpopulation() {
			super();
		}

		public Long getPopulation_id() {
			return Population_id;
		}

		public void setPopulation_id(Long population_id) {
			Population_id = population_id;
		}

		public String getRegions() {
			return Regions;
		}

		public void setRegions(String regions) {
			Regions = regions;
		}

		public String getEnvironment() {
			return environment;
		}

		public void setEnvironment(String environment) {
			this.environment = environment;
		}

		public String getSexe() {
			return Sexe;
		}

		public void setSexe(String sexe) {
			Sexe = sexe;
		}

		public Long getDistribution_of_population() {
			return Distribution_of_population;
		}

		public void setDistribution_of_population(Long distribution_of_population) {
			Distribution_of_population = distribution_of_population;
		}

		public Long getNumber_houses() {
			return number_houses;
		}

		public void setNumber_houses(Long number_houses) {
			this.number_houses = number_houses;
		}

		public Long getLess_than_1Km() {
			return less_than_1Km;
		}

		public void setLess_than_1Km(Long less_than_1Km) {
			this.less_than_1Km = less_than_1Km;
		}

		public Long getBetween_1KM_2Km() {
			return Between_1KM_2Km;
		}

		public void setBetween_1KM_2Km(Long between_1km_2Km) {
			Between_1KM_2Km = between_1km_2Km;
		}

		public Long getPlus2Km() {
			return Plus2Km;
		}

		public void setPlus2Km(Long plus2Km) {
			Plus2Km = plus2Km;
		}

		public Long getPopulation_aged_15_and_plus() {
			return Population_aged_15_and_plus;
		}

		public void setPopulation_aged_15_and_plus(Long population_aged_15_and_plus) {
			Population_aged_15_and_plus = population_aged_15_and_plus;
		}

		public Long getActive_Population_Occupied() {
			return active_Population_Occupied;
		}

		public void setActive_Population_Occupied(Long active_Population_Occupied) {
			this.active_Population_Occupied = active_Population_Occupied;
		}

		public Long getInactive_Population() {
			return Inactive_Population;
		}

		public void setInactive_Population(Long inactive_Population) {
			Inactive_Population = inactive_Population;
		}

		public float getActivity_rate() {
			return activity_rate;
		}

		public void setActivity_rate(float activity_rate) {
			this.activity_rate = activity_rate;
		}

		public float getUnemployment_rate() {
			return Unemployment_rate;
		}

		public void setUnemployment_rate(float unemployment_rate) {
			Unemployment_rate = unemployment_rate;
		}

		public Long getUnemployed_Neant() {
			return Unemployed_Neant;
		}

		public void setUnemployed_Neant(Long unemployed_Neant) {
			Unemployed_Neant = unemployed_Neant;
		}

		public Long getUnemployed_Primary() {
			return Unemployed_Primary;
		}

		public void setUnemployed_Primary(Long unemployed_Primary) {
			Unemployed_Primary = unemployed_Primary;
		}

		public Long getUnemployed_Secondary() {
			return Unemployed_Secondary;
		}

		public void setUnemployed_Secondary(Long unemployed_Secondary) {
			Unemployed_Secondary = unemployed_Secondary;
		}

		public Long getUnemployed_faculty() {
			return Unemployed_faculty;
		}

		public void setUnemployed_faculty(Long unemployed_faculty) {
			Unemployed_faculty = unemployed_faculty;
		}

		public Long getUnemployed_Agriculture_fishing() {
			return Unemployed_Agriculture_fishing;
		}

		public void setUnemployed_Agriculture_fishing(Long unemployed_Agriculture_fishing) {
			Unemployed_Agriculture_fishing = unemployed_Agriculture_fishing;
		}

		public Long getUnemployed_Mines_energy() {
			return Unemployed_Mines_energy;
		}

		public void setUnemployed_Mines_energy(Long unemployed_Mines_energy) {
			Unemployed_Mines_energy = unemployed_Mines_energy;
		}

		public Long getUnemployed_manufacturing_Industry() {
			return Unemployed_manufacturing_Industry;
		}

		public void setUnemployed_manufacturing_Industry(Long unemployed_manufacturing_Industry) {
			Unemployed_manufacturing_Industry = unemployed_manufacturing_Industry;
		}

		public Long getUnemployed_Building_public_works() {
			return Unemployed_Building_public_works;
		}

		public void setUnemployed_Building_public_works(Long unemployed_Building_public_works) {
			Unemployed_Building_public_works = unemployed_Building_public_works;
		}

		public Long getUnemployed_Commerce() {
			return Unemployed_Commerce;
		}

		public void setUnemployed_Commerce(Long unemployed_Commerce) {
			Unemployed_Commerce = unemployed_Commerce;
		}

		public Long getUnemployed_Transport() {
			return Unemployed_Transport;
		}

		public void setUnemployed_Transport(Long unemployed_Transport) {
			Unemployed_Transport = unemployed_Transport;
		}

		public Long getUnemployed_Education_health_administrative_services() {
			return Unemployed_Education_health_administrative_services;
		}

		public void setUnemployed_Education_health_administrative_services(
				Long unemployed_Education_health_administrative_services) {
			Unemployed_Education_health_administrative_services = unemployed_Education_health_administrative_services;
		}

		public Long getUnemployed_Other_services() {
			return Unemployed_Other_services;
		}

		public void setUnemployed_Other_services(Long unemployed_Other_services) {
			Unemployed_Other_services = unemployed_Other_services;
		}

		public Long getUnemployed_Undeclared() {
			return Unemployed_Undeclared;
		}

		public void setUnemployed_Undeclared(Long unemployed_Undeclared) {
			Unemployed_Undeclared = unemployed_Undeclared;
		}

		public Long getUnemployed_15_19_years_Age() {
			return Unemployed_15_19_years_Age;
		}

		public void setUnemployed_15_19_years_Age(Long unemployed_15_19_years_Age) {
			Unemployed_15_19_years_Age = unemployed_15_19_years_Age;
		}

		public Long getUnemployed_20_24_years_Age() {
			return Unemployed_20_24_years_Age;
		}

		public void setUnemployed_20_24_years_Age(Long unemployed_20_24_years_Age) {
			Unemployed_20_24_years_Age = unemployed_20_24_years_Age;
		}

		public Long getUnemployed_25_29_years_Age() {
			return Unemployed_25_29_years_Age;
		}

		public void setUnemployed_25_29_years_Age(Long unemployed_25_29_years_Age) {
			Unemployed_25_29_years_Age = unemployed_25_29_years_Age;
		}

		public Long getUnemployed_30_34_years_Age() {
			return Unemployed_30_34_years_Age;
		}

		public void setUnemployed_30_34_years_Age(Long unemployed_30_34_years_Age) {
			Unemployed_30_34_years_Age = unemployed_30_34_years_Age;
		}

		public Long getUnemployed_35_39_years_Age() {
			return Unemployed_35_39_years_Age;
		}

		public void setUnemployed_35_39_years_Age(Long unemployed_35_39_years_Age) {
			Unemployed_35_39_years_Age = unemployed_35_39_years_Age;
		}

		public Long getUnemployed_40_44_years_Age() {
			return Unemployed_40_44_years_Age;
		}

		public void setUnemployed_40_44_years_Age(Long unemployed_40_44_years_Age) {
			Unemployed_40_44_years_Age = unemployed_40_44_years_Age;
		}

		public Long getUnemployed_45_49_years_Age() {
			return Unemployed_45_49_years_Age;
		}

		public void setUnemployed_45_49_years_Age(Long unemployed_45_49_years_Age) {
			Unemployed_45_49_years_Age = unemployed_45_49_years_Age;
		}

		public Long getUnemployed_50_59_years_Age() {
			return Unemployed_50_59_years_Age;
		}

		public void setUnemployed_50_59_years_Age(Long unemployed_50_59_years_Age) {
			Unemployed_50_59_years_Age = unemployed_50_59_years_Age;
		}

		public Long getUnemployed_60plus_years() {
			return Unemployed_60plus_years;
		}

		public void setUnemployed_60plus_years(Long unemployed_60plus_years) {
			Unemployed_60plus_years = unemployed_60plus_years;
		}


		@Override
		public String toString() {
			return "unemployedpopulation [Population_id=" + Population_id + ", Regions=" + Regions + ", environment="
					+ environment + ", Sexe=" + Sexe + ", Distribution_of_population=" + Distribution_of_population
					+ ", number_houses=" + number_houses + ", less_than_1Km=" + less_than_1Km + ", Between_1KM_2Km="
					+ Between_1KM_2Km + ", Plus2Km=" + Plus2Km + ", Population_aged_15_and_plus="
					+ Population_aged_15_and_plus + ", active_Population_Occupied=" + active_Population_Occupied
					+ ", Inactive_Population=" + Inactive_Population + ", activity_rate=" + activity_rate
					+ ", Unemployment_rate=" + Unemployment_rate + ", Unemployed_Neant=" + Unemployed_Neant
					+ ", Unemployed_Primary=" + Unemployed_Primary + ", Unemployed_Secondary=" + Unemployed_Secondary
					+ ", Unemployed_faculty=" + Unemployed_faculty + ", Unemployed_Agriculture_fishing="
					+ Unemployed_Agriculture_fishing + ", Unemployed_Mines_energy=" + Unemployed_Mines_energy
					+ ", Unemployed_manufacturing_Industry=" + Unemployed_manufacturing_Industry
					+ ", Unemployed_Building_public_works=" + Unemployed_Building_public_works
					+ ", Unemployed_Commerce=" + Unemployed_Commerce + ", Unemployed_Transport=" + Unemployed_Transport
					+ ", Unemployed_Education_health_administrative_services="
					+ Unemployed_Education_health_administrative_services + ", Unemployed_Other_services="
					+ Unemployed_Other_services + ", Unemployed_Undeclared=" + Unemployed_Undeclared
					+ ", Unemployed_15_19_years_Age=" + Unemployed_15_19_years_Age + ", Unemployed_20_24_years_Age="
					+ Unemployed_20_24_years_Age + ", Unemployed_25_29_years_Age=" + Unemployed_25_29_years_Age
					+ ", Unemployed_30_34_years_Age=" + Unemployed_30_34_years_Age + ", Unemployed_35_39_years_Age="
					+ Unemployed_35_39_years_Age + ", Unemployed_40_44_years_Age=" + Unemployed_40_44_years_Age
					+ ", Unemployed_45_49_years_Age=" + Unemployed_45_49_years_Age + ", Unemployed_50_59_years_Age="
					+ Unemployed_50_59_years_Age + ", Unemployed_60plus_years=" + Unemployed_60plus_years + "]";
		}

		
}
