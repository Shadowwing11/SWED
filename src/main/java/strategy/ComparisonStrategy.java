package strategy;

public interface ComparisonStrategy {
    boolean isUpdated(String oldContent, String newContent);
}