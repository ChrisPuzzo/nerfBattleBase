package nerfUser;

// The user class used to house the user details 
public class User {
	
	private String userName;
	private String userID;
	private int wins = 0;
	private int elims = 0;
	private int gamesPlayed = 0;
	private double winPercent = 0.0;
	private double kd = 0.0;
	private int deaths = 0;
	
	// Constructor
	public User(String usern) 
	{
		this.setUserName(usern);
		userName = usern;
		this.genUserID();
		this.genKd();
	}
	
	
	// Generate Random UserID
	private void genUserID(){
		double dig;
		String digStr;
		int min = 10000;
		int max = 99999;
		int range = max - min + 1;
		dig = (int)Math.round(Math.random() * range + min);
		digStr = String.valueOf(dig);
		this.setUserID(digStr);
	}
	
	// generates a kill to death ration 
	private void genKd() {
		double newKd;
		if (this.deaths == 0) {
			setKd(this.elims);
		}
		else {
			newKd = this.elims/this.deaths;
			setKd(newKd);
		}
	}
	
	// states the user participated in a game
	public void playGame() {
		int games = getGamesPlayed();
		this.setGamesPlayed(games + 1);
	}
	
	// generates their win percentages
	private void genWinPer()
	{
		double winPer;
		winPer = this.wins/this.gamesPlayed;
		setWinPercent(winPer);
	}
	
	// adds a win to this player
	public void win()
	{
		setWins(getWins() + 1);
		genWinPer();
	}
	
	// adds a kill to this player
	public void elimination()
	{
		setElims(getElims() + 1);
		genKd();
	}
	// adds a death to this player
	public void death() {
		setDeaths(getDeaths() + 1);
		genKd();
		genWinPer();
	}
	
	
	// Getter and Setter for userName
	public String getUserName() {
		return userName;
	}
	
	private void setUserName(String userName) {
		this.userName = userName;
	}
	
	// Getter and Setter for userID
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	// Getter and Setter for getWins
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}

	// Getter and Setter for elims
	public int getElims() {
		return elims;
	}

	public void setElims(int elims) {
		this.elims = elims;
	}
	
	// Getter and Setter for gamesPlayed
	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	
	// Getter and Setter for winPercent
	public double getWinPercent() {
		return winPercent;
	}

	public void setWinPercent(double winPercent) {
		this.winPercent = winPercent;
	}
	
	// Getter and Setter for getKd
	public double getKd() {
		return kd;
	}

	public void setKd(double kd) {
		this.kd = kd;
	}


	public int getDeaths() {
		return deaths;
	}


	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	
	
	
}
