package strategy;

public class SizeComparisonStrategy implements ComparisonStrategy {
    @Override
    public boolean isUpdated(String oldContent, String newContent) {
        return oldContent.length() != newContent.length();
    }
}