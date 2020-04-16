package creational.factory;

public class DocumentFactory {
    public Document create(DocumentType type){
        Document document = null;
        switch (type){
            case PDF:
                document = new PDF();
                break;
            case TXT:
                document = new TXT();
                break;
            case HTML:
                throw new UnsupportedOperationException();
        }
        return document;
    }


}
