package takarivi.bibtex.enums;

public enum FieldType {

    ADDRESS("Address", ContentType.STRING),
    AUTHOR("Author", ContentType.STRING),
    BOOKTITLE("BookTitle", ContentType.STRING),
    EDITION("Edition", ContentType.STRING),
    EDITOR("Editor", ContentType.STRING),
    JOURNAL("Journal", ContentType.STRING),
    KEY("Key", ContentType.STRING),
    MONTH("Month", ContentType.STRING),
    NOTE("Note", ContentType.STRING),
    NUMBER("Number", ContentType.STRING),
    ORGANIZATION("Organization", ContentType.STRING),
    PAGES("Pages", ContentType.STRING),
    PUBLISHER("Publisher", ContentType.STRING),
    SERIES("Series", ContentType.STRING),
    TITLE("Title", ContentType.STRING),
    VOLUME("Volume", ContentType.STRING),
    YEAR("Year", ContentType.STRING);

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
