import java.util.ArrayList;
import java.util.List;

class StringBuilderWithUndo {
    private final StringBuilder stringBuilder;
    private final List<Command> commandHistory;

    public StringBuilderWithUndo() {
        this.stringBuilder = new StringBuilder();
        this.commandHistory = new ArrayList<>();
    }

    public void append(String text) {
        AppendCommand appendCommand = new AppendCommand(text);
        appendCommand.execute(stringBuilder);
        commandHistory.add(appendCommand);
    }

    public void insert(int offset, String text) {
        InsertCommand insertCommand = new InsertCommand(offset, text);
        insertCommand.execute(stringBuilder);
        commandHistory.add(insertCommand);
    }

    public void replace(int start, int end, String text) {
        ReplaceCommand replaceCommand = new ReplaceCommand(start, end, text);
        replaceCommand.execute(stringBuilder);
        commandHistory.add(replaceCommand);
    }

    public void delete(int start, int end) {
        DeleteCommand deleteCommand = new DeleteCommand(start, end);
        deleteCommand.execute(stringBuilder);
        commandHistory.add(deleteCommand);
    }

    public void reverse() {
        ReverseCommand reverseCommand = new ReverseCommand();
        reverseCommand.execute(stringBuilder);
        commandHistory.add(reverseCommand);
    }

    public void undo() {
        if (!commandHistory.isEmpty()) {
            int lastIndex = commandHistory.size() - 1;
            Command lastCommand = commandHistory.get(lastIndex);
            lastCommand.undo(stringBuilder);
            commandHistory.remove(lastIndex);
        }
    }

    public String toString() {
        return stringBuilder.toString();
    }
}
