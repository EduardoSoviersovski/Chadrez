package Game;

public interface SaveRankingDAO {
    // Metodos
    public void createPlayerListTxt();
    public void newPlayerTxt(Player newPlayer);
    public boolean isNewPlayerTxt(Player player);
    public void updateRankingTxt(String name, int wins);
    public void createPlayerListDoc();
    public void newPlayerDoc(Player newPlayer);
    public boolean isNewPlayerDoc(Player player);
    public void updateRankingDoc(String name, int wins);
}
