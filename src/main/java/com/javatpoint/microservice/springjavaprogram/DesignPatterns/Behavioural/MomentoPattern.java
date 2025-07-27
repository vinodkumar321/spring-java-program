package com.javatpoint.microservice.springjavaprogram.DesignPatterns.Behavioural;

/*
   Behavioural Design Patterns  -->  Deals with Object interaction & Responsibility
     -->  Momento
                -> allows you to capture and restore an object's state without violating encapsulation.
                -> Capture and externalize an object’s internal state so that the object can be restored to this state later, without exposing its internals.

                | Component      | Role                                                            |
| -------------- | --------------------------------------------------------------- |
| **Originator** | The object whose state you want to save and restore             |
| **Memento**    | A value object that holds the state of the Originator           |
| **Caretaker**  | Manages memento stack and requests restores from the Originator |

                -> Use Cases
                        -> Undo/redo functionality in editors
                        -> State checkpoint in games
                        -> Configuration snapshots
                        -> Transaction rollback mechanisms

                -> Considerations
                        -> Storing many mementos can use a lot of memory
                        -> Caretaker should not modify mementos
*/

import java.util.Stack;

public class MomentoPattern {
    public static void main(String[] args) {
        System.out.println("Behavioural Design Patterns  -->  Deals with Object interaction & Responsibility");
        System.out.println();
        System.out.println("Behavioural Design Pattern Examples -> Momento");
        TextEditor editor = new TextEditor();
        EditorHistory history = new EditorHistory();

        editor.setText("Version 1");
        history.save(editor);

        editor.setText("Version 2");
        history.save(editor);

        editor.setText("Version 3");

        System.out.println("Current: " + editor.getText()); // Version 3
        history.undo(editor);
        System.out.println("After Undo: " + editor.getText()); // Version 2
        history.undo(editor);
        System.out.println("After Undo: " + editor.getText()); // Version 1
    }
}

class TextMemento {
    private final String text;

    public TextMemento(String text) {
        this.text = text;
    }

    public String getSavedText() {
        return text;
    }
}

class TextEditor {
    private String text = "";

    public void setText(String newText) {
        this.text = newText;
    }

    public String getText() {
        return text;
    }

    public TextMemento save() {
        return new TextMemento(text);
    }

    public void restore(TextMemento memento) {
        this.text = memento.getSavedText();
    }
}


class EditorHistory {
    private Stack<TextMemento> history = new Stack<>();

    public void save(TextEditor editor) {
        history.push(editor.save());
    }

    public void undo(TextEditor editor) {
        if (!history.isEmpty()) {
            editor.restore(history.pop());
        }
    }
}






