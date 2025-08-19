package pages.components;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FileUploadComponent {
    public void pictureToDownload(File file) {
        // Loaded file
        $x("//label[@id='subjects-label' and text()='Picture']")
                .shouldBe(visible);
        $("#uploadPicture").uploadFile(file);

    }
}
