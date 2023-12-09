interface Command {
    void execute(StringBuilder stringBuilder);

    void undo(StringBuilder stringBuilder);
}

class AppendCommand implements Command {
    private final String text;

    AppendCommand(String text) {
        this.text = text;
    }

    @Override
    public void execute(StringBuilder stringBuilder) {
        stringBuilder.append(text);
    }

    @Override
    public void undo(StringBuilder stringBuilder) {
        int lengthToRemove = text.length();
        int currentLength = stringBuilder.length();
        if (currentLength >= lengthToRemove) {
            stringBuilder.delete(currentLength - lengthToRemove, currentLength);
        }
    }
}

class InsertCommand implements Command {
    private final int offset;
    private final String text;

    InsertCommand(int offset, String text) {
        this.offset = offset;
        this.text = text;
    }

    @Override
    public void execute(StringBuilder stringBuilder) {
        stringBuilder.insert(offset, text);
    }

    @Override
    public void undo(StringBuilder stringBuilder) {
        int lengthToRemove = text.length();
        int currentLength = stringBuilder.length();
        if (currentLength >= lengthToRemove + offset) {
            stringBuilder.delete(offset, offset + lengthToRemove);
        }
    }
}

class ReplaceCommand implements Command {
    private final int start;
    private final int end;
    private final String text;

    ReplaceCommand(int start, int end, String text) {
        this.start = start;
        this.end = end;
        this.text = text;
    }

    @Override
    public void execute(StringBuilder stringBuilder) {
        stringBuilder.replace(start, end, text);
    }

    @Override
    public void undo(StringBuilder stringBuilder) {
        stringBuilder.replace(start, start + text.length(), "");
    }
}

class DeleteCommand implements Command {
    private final int start;
    private final int end;
    private String deletedText;

    DeleteCommand(int start, int end) {
        this.start = start;
        this.end = end;
        deletedText = null;
    }

    @Override
    public void execute(StringBuilder stringBuilder) {
        deletedText = stringBuilder.substring(start, end);
        stringBuilder.delete(start, end);
    }

    @Override
    public void undo(StringBuilder stringBuilder) {
        stringBuilder.insert(start, deletedText);
    }
}

class ReverseCommand implements Command {
    @Override
    public void execute(StringBuilder stringBuilder) {
        stringBuilder.reverse();
    }

    @Override
    public void undo(StringBuilder stringBuilder) {
        // Поскольку reverse() выполняет инверсию в одно действие,
        // undo для reverse() также просто выполняет reverse()
        stringBuilder.reverse();
    }
}