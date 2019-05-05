import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import javax.swing.*;

public class ClipboardExample extends JFrame {


/*
 * Кнопка инициации копирования текста в буфер обмена.

private JButton button = new JButton("Copy to clipboard");
/**
 * Текстовое поле, для ввода данных.

private JTextField textField = new JTextField("Text to copy to clipboard ...");
/**
 * Объект, для взаимодействия с буфером обмена.

private Clipboard clipboard = Toolkit
        .getDefaultToolkit()
        .getSystemClipboard();

//public Clipboard.ClipboardExample() {
        // настраиваем окно
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setTitle("Clipboard interoperability example");
        // добавляем элементы управления
        add(button, BorderLayout.LINE_END);
        add(textField);
        // добавляем обработчик нажатия на кнопку
        button.addActionListener(this::onButtonClick);
        // упаковываем интерфейс так, чтобы всё поместилось на экране
        pack();
        }
/**
 * Выполняет копирование тектса в буфер обмена.
 *
 * @param text текстовые данные, которые следует поместить в буфер обмена
 *
private void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, selection);
        }
/**
 * Проверяет, что строка не пустая.
 *
 * @param text текстовые данные
 * @returns ture, если переданная строка null, не содержит символов, или
 * 			содержит только пробельные символы. В обратном случае - false.
 *
private boolean isBlank(String text) {
        return text == null || text.trim().isEmpty();
        }
/**
 * Обработчик события нажатия на кнопку.
 *
 * <p> Выполняет копирование текста из текстового поля в буфер обмена,
 * если тектс не пустой.
 *
 * @param e аргуметны события
 *
private void onButtonClick(ActionEvent e) {
        String text = textField.getText();
        if (!isBlank(text)) copyToClipboard(text);
        }

*/        }