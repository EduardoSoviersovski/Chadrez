package Game;

public interface SaveGameDAO {
    // Metodos
    public void setSaveDoc();

    public String getSaveDoc();

    public void createSaveDoc();

    public void deleteSaveDoc(String nameBlack, String nameWhite);

    public void setSaveTxt();

    public String getSaveTxt();

    public void createSaveTxt();

    public void deleteSaveTxt(String nameBlack, String nameWhite);
}
