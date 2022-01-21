package asciibreaker.model;

import asciibreaker.controller.command.ButtonCommand;

import java.util.List;

public class Button {
    private List<String> buttonText;
    private Position upperLeft;
    private Position lowerRight;
    private String buttonColor;
    private String textColor;
    private boolean active;
    private ButtonCommand action;

    public Button(List<String> buttonText, Position upperLeft, Position lowerRight, String buttonColor, String textColor) {
        this.buttonText = buttonText;
        this.upperLeft = upperLeft;
        this.lowerRight = lowerRight;
        this.buttonColor = buttonColor;
        this.textColor = textColor;
        this.active = false;
    }

    public List<String> getButtonText() { return buttonText; }

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) { this.active = active; }

    public void setAction(ButtonCommand action) { this.action = action; }

    public ButtonCommand getAction() { return action; }

}
