package Game;

public interface SaveRankingDAO {
    //Metodos
    public void createPlayerList();
    public void createRanking();
    public void newPlayer(Player newPlayer);
    public boolean isNewPlayer(Player player);
}
