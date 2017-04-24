package takarivi.bibtex.enums;

public enum FieldType {

    AUTHOR("Author", ContentType.STRING),
    EDITOR("Editor", ContentType.STRING),
    TITLE("Title", ContentType.STRING),
    BOOKTITLE("BookTitle", ContentType.STRING),
    YEAR("Year", ContentType.STRING),
    ADDRESS("Address", ContentType.STRING),
    EDITION("Edition", ContentType.STRING),
    JOURNAL("Journal", ContentType.STRING),
    KEY("Key", ContentType.STRING),
    MONTH("Month", ContentType.STRING),
    NOTE("Note", ContentType.STRING),
    NUMBER("Number", ContentType.STRING),
    ORGANIZATION("Organization", ContentType.STRING),
    PAGES("Pages", ContentType.STRING),
    PUBLISHER("Publisher", ContentType.STRING),
    SERIES("Series", ContentType.STRING),
    VOLUME("Volume", ContentType.STRING);

    private final String title;
    private final ContentType contentType;

    private FieldType(final String title, final ContentType contentType) {
        this.title = title;
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return title;
    }
}
