package strategy;

public class HtmlComparisonStrategy implements ComparisonStrategy {
    @Override
    public boolean isUpdated(String oldContent, String newContent) {
        return !oldContent.equals(newContent);
    }
}
