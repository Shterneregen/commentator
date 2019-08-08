package random;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Frame {

    public TextField firstComment;
    public TextField lastComment;

    public TextArea originalText;
    public TextArea newText;
    public ChoiceBox<String> lineSeparatorChoiceBox = new ChoiceBox<>();

    private String currentLineSeparators;

    @FXML
    public void initialize() {
        List<String> lineSeparators = Arrays.stream(LineSeparator.values())
                .map(LineSeparator::getName)
                .collect(Collectors.toList());
        lineSeparatorChoiceBox.getItems().addAll(FXCollections.observableArrayList(lineSeparators));
        lineSeparatorChoiceBox.setValue(LineSeparator.CURRENT.getName());
        lineSeparatorChoiceBox.setOnAction(event -> currentLineSeparators = LineSeparator.getSeparatorByName(lineSeparatorChoiceBox.getValue()));
    }

    @FXML
    private void replace() {
        String text = Replacer.commentText(originalText.getText(), firstComment.getText(), lastComment.getText(),
                LineSeparator.CURRENT.getSeparator());
        newText.setText(text);
    }

}
