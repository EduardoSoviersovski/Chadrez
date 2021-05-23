package Game;

public interface ReadRankingDAO {

    public boolean isNewPlayerTxt(Player player);

    public void readWinsTxt(Player player);

    public String readRankingTxt();

    public void readRankingTxtFile(Player blackPlayer, Player whitePlayer);
    
    public boolean isNewPlayerDoc(Player player);

    public void readWinsDoc(Player player);
    
    public String readRankingDoc();
    
    public void readRankingDocFile(Player blackPlayer, Player whitePlayer);

}