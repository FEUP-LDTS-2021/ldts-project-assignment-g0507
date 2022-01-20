package asciibreaker.model;

public class Button {
    private String buttonText;
    private Position upperLeft;
    private Position lowerRight;
    private String buttonColor;
    private String textColor;

    public Button(String buttonText, Position upperLeft, Position lowerRight, String buttonColor, String textColor) {
        this.buttonText = buttonText;
        this.upperLeft = upperLeft;
        this.lowerRight = lowerRight;
        this.buttonColor = buttonColor;
        this.textColor = textColor;
    }

    public String getButtonText() {
        return buttonText;
    }

    public Position getUpperLeft() {
        return upperLeft;
    }

    public Position getLowerRight() {
        return lowerRight;
    }

    public String getButtonColor() {
        return buttonColor;
    }

    public String getTextColor() {
        return textColor;
    }
}
