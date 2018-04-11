package client.view;

import client.IServiceStub;
import client.controller.ClientController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

class AddItemDialog extends Dialog{


    AddItemDialog(ClientController clientController, String string) {
        super(clientController, string);
        dialog.pack();
        dialog.setVisible(true);
    }

    @Override
    void action() {
        if(name.getText().isEmpty()){
            JOptionPane.showMessageDialog(dialog, "Field is empty",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String str = name.getText();
            List<IServiceStub.Chapter> chapters = new ArrayList<>();
            IServiceStub.Chapter chapter = new IServiceStub.Chapter();
            chapter.setName("new chapter");
            chapter.setText("");
            chapters.add(chapter);
            IServiceStub.Author author = new IServiceStub.Author();
            author.setFirstName("");
            author.setSecondName("");
            IServiceStub.Item item = new IServiceStub.Item();
            item.setAuthor(author);
            item.setChapters(chapters.toArray(new IServiceStub.Chapter[chapters.size()]));
            item.setName(str);
            item.setYearOfPublication(2018);
            clientController.addItem(item);
            dialog.dispose();
        }
    }
}
