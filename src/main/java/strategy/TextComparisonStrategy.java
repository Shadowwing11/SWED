package strategy;

public class TextComparisonStrategy implements ComparisonStrategy {
    @Override
    public boolean isUpdated(String oldContent, String newContent) {
        String oldText = oldContent.replaceAll("<[^>]+>", "").trim();
        String newText = newContent.replaceAll("<[^>]+>", "").trim();
        return !oldText.equals(newText);
    }
}