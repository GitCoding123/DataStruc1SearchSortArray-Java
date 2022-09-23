/**
 * This State class possesses attributes
 * in which we can create state objects from.
 * 
 * @author bgerk
 * @version 9/16/21
 */

//Class State
public class State {
	private String name;
	private String capitol;
	private String region;
	private int usHouseSeats;
	private int population;
	private double covidCases;
	private double covidDeaths;
	private int income;
	private double crimeRate;	
	private double CFR;
	private double caseRate;
	private double deathRate;
	/**
	 * This is the default constructor 
	 */
	public State() {
		this.name = "";
		this.capitol = "";
		this.region = "";
		this.usHouseSeats = 0;
		this.population = 0;
		this.covidCases = 0.0;
		this.covidDeaths = 0.0;
		this.income = 0;
		this.crimeRate = 0.0;
		this.CFR = 0.0;
		this.caseRate = 0.0;
		this.deathRate = 0.0;
	}
	/**
	 * This is the State constructor with all attributes.
	 * 
	 * @param name, capitol, region, usHouseSeats,population, covidCases, covidDeaths, income, crimeRate, CFR, caseRate, deathRate 
	 */
	public State(String name, String capitol, String region, int usHouseSeats, int population, double covidCases, double covidDeaths, int income, double crimeRate, double CFR, double caseRate, double deathRate) {
		this.name = name;
		this.capitol = capitol;
		this.region = region;
		this.usHouseSeats = usHouseSeats;
		this.population = population;
		this.covidCases = covidCases;
		this.covidDeaths = covidDeaths;
		this.income = income;
		this.crimeRate = crimeRate;
		this.CFR = covidCases / covidDeaths;
		this.caseRate = covidCases / population * 100000;
		this.deathRate = covidDeaths / population * 100000;
		
	}
	
	/**
	 * main method 
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		
		//System.out.println(s.toString());
	}
	
	/**
	 * getName() returns the name of the state object.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * setName() sets the name of the state object from the csv file
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * 
	 * @return
	 */
	public String getCapitol() {
		return capitol;
	}
	/**
	 * setCapitol() sets the capitol of the state object from the csv file
	 * 
	 * @param capitol
	 */
	public void setCapitol(String capitol) {
		this.capitol = capitol;
	}
	/**
	 * 
	 * @return
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * setRegion() sets the region of the state object from the csv file
	 * 
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * 
	 * @return
	 */
	public int getUsHouseSeats() {
		return usHouseSeats;
	}
	/**
	 * setUsHouseSeats() sets the house seats of the state object from the csv file
	 * 
	 * @param usHouseSeats
	 */
	public void setUsHouseSeats(int usHouseSeats) {
		this.usHouseSeats = usHouseSeats;
	}
	/**
	 * 
	 * @return
	 */
	public int getPopulation() {
		return population;
	}
	/**
	 * setPopulation() sets the population of the state object from the csv file
	 * 
	 * @param population
	 */
	public void setPopulation(int population) {
		this.population = population;
	}
	/**
	 * 
	 * @return
	 */
	public double getCovidCases() {
		return covidCases;
	}
	/**
	 * setCovidCases() sets the covid cases of the state object from the csv file
	 * 
	 * @param covidCases
	 */
	public void setCovidCases(double covidCases) {
		this.covidCases = covidCases;
	}
	/**
	 * 
	 * @return
	 */
	public double getCovidDeaths() {
		return covidDeaths;
	}
	/**
	 * setCovidDeaths() sets the covid deaths of the state object from the csv file
	 * 
	 * @param covidDeaths
	 */
	public void setCovidDeaths(double covidDeaths) {
		this.covidDeaths = covidDeaths;
	}
	/**
	 * 
	 * @return
	 */
	public int getIncome() {
		return income;
	}
	/**
	 * setIncome() sets the income of the state object from the csv file
	 * 
	 * @param income
	 */
	public void setIncome(int income) {
		this.income = income;
	}
	/**
	 * 
	 * @return
	 */
	public double getCrimeRate() {
		return crimeRate;
	}
	/**
	 * setCrimeRate() sets the crime rate of the state object from the csv file
	 * 
	 * @param crimeRate
	 */
	public void setCrimeRate(double crimeRate) {
		this.crimeRate = crimeRate;
	}
	/**
	 * 
	 * @return
	 */
	public double getCFR() {
		return CFR;
	}
	/**
	 * setCFR() sets the CFR of the state object from our defined CFR variable
	 * 
	 * @param CFR
	 */
	public void setCFR(double CFR) {
		this.CFR = CFR;
	}
	/**
	 * 
	 * @return
	 */
	public double getCaseRate() {
		return caseRate;
	}
	/**
	 * setCaseRate() sets the case rate of the state object from our defined caseRate variable
	 * 
	 * @param caseRate
	 */
	public void setCaseRate(double caseRate) {
		this.caseRate = caseRate;
	}
	/**
	 * 
	 * @return
	 */
	public double getDeathRate() {
		return deathRate;
	}
	/**
	 * setDeathRate() sets the death rate of the state object from our defined deathRate variable
	 * 
	 * @param deathRate
	 */
	public void setDeathRate(double deathRate) {
		this.deathRate = deathRate;
	}
	/**
	 * compareTo() method compares our state objects to a sample state we pass through the method.
	 * 
	 * @param state1
	 * @return value either <0, >0, or =0.
	 */
	public int compareTo(State sampleState) {
			return this.getName().compareTo(sampleState.getName());
	}
	/**
	 * toString() method returns a visual representation of our state object
	 * 
	 * @return name + capitol + region + usHouseSeats + population + covidCases + covidDeaths + income + crimeRate + CFR + caseRate + deathRate
	 */
	@Override
	public String toString() {
		return name + " " + capitol + " " + region + " " + usHouseSeats + " " + population + " " + covidCases + " " + covidDeaths + " " + income + " " + crimeRate + " " + CFR + " " + caseRate + " " + deathRate;
	}
	
	

	
	
	
}