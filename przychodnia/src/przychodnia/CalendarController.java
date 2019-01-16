package przychodnia;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import kalendarz.Container;
import kalendarz.dao.NoteDao;
import kalendarz.entity.Note;
import kalendarz.entity.TableNote;
import kalendarz.enums.Switch;

/**
 * Klasa controller obs3uguj1ca widok Calendar.fxml
 * @author Ananke
 *
 */
public class CalendarController implements Initializable{

	@FXML
	private GridPane idGrid;

	@FXML
	private Button idMonth;

	@FXML
	private Button idYear;

	@FXML
	private TableView<TableNote> idTable;

	@FXML
	private TableColumn<TableNote, String> idTitle;

	@FXML
	private TableColumn<TableNote, String> idContent;

	private LocalDate localDate, selectedDateForEvent;
	private NoteDao noteDao = new NoteDao();
	private ObservableList<TableNote> observableArrayList = FXCollections.observableArrayList();
	//zmienna przychowywuj1ca wybrany dzien z kalendarza
	private int selectedDay = 0;
	private int month = 0;
	private int year = 0;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (localDate == null) {
			localDate = LocalDate.now();
		}
		drawCalendar(Switch.DEFAULT);
	}

	/**
	 * Metoda rysuj1ca kalendarz.
	 * @param s wartooa w klasy enmu Switch
	 * dat1 wyjociow1 jest aktualna data
	 * MONTH_PLUS - cofa kalendarz o miesi1c wstecz
	 * MONTH_MINUS - przesuwa kalendarz o miesi1c do przodu
	 * YEAR_PLUS - przesuwa kalendarz o rok do przodu
	 * YEAR_MINUS - cofa kalendarz o rok wstecz
	 * DEFAULT
	 */
	private void drawCalendar(Switch s) {
		clearGrid();
		switch (s) {
		case MONTH_MINUS:
			--month;
			break;
		case MONTH_PLUS:
			++month;
			break;
		case YEAR_MINUS:
			--year;
			break;
		case YEAR_PLUS:
			++year;
			break;
		case DEFAULT:
			break;
		}
		
		//zmienna przechowywuj1ca date
		LocalDate selectedDate = LocalDate.now().plusMonths(month).plusYears(year);
		//przekazuje miesi1c do przycisku
		idMonth.setText(selectedDate.getMonth().toString());
		//przekazuje rok do przycisku
		idYear.setText(selectedDate.getYear() + "");
		//zmienna przechowywuj1ca numer dnia tygodnia
		int dayOfWeekValue = selectedDate.withDayOfMonth(1).getDayOfWeek().getValue() - 1;
		//zmienna przechowywuj1ca dzien
		int x = 1;
		for (int i = 0; i < selectedDate.lengthOfMonth(); i++) {
			String dayNumber = i + 1 + "";
			if (dayOfWeekValue == 7) {
				x += 1;
				dayOfWeekValue = 0;
			}
			idGrid.add(createButton(dayNumber, selectedDate, dayOfWeekValue), dayOfWeekValue, x);
			dayOfWeekValue++;
		}
	}

	/**
	 * metoda odpowiedzialna za czyszczenie widoku kalendarza
	 */
	private void clearGrid() {
		idGrid.getChildren().remove(7, idGrid.getChildren().size());
	}
	
	
	/**
	 * Metoda odpowiedzalna za tworzenie przycisków kalendarza
	 * @param name Numer dnia
	 * @param date Data
	 * @param dayOfWeekValue Numer dnia tygodnia
	 * @return button
	 */
	private Button createButton(String name, LocalDate date, int dayOfWeekValue) {
		Button button = new Button(name);
		button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		button.setFocusTraversable(false);
		
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				selectedDay = Integer.parseInt(button.getText());
				button.setFocusTraversable(true);
				button.requestFocus();
				observableArrayList.removeAll(observableArrayList);
				selectedDateForEvent = date.withDayOfMonth(selectedDay);
				drawTable(selectedDateForEvent);
				
			}

		});
		if (localDate.getDayOfMonth() == Integer.parseInt(name) && date.equals(localDate)) {
			button.setStyle("-fx-border-color: red");
			button.setFocusTraversable(true);
			button.requestFocus();
			selectedDay = localDate.getDayOfMonth();
			drawTable(date.withDayOfMonth(Integer.parseInt(button.getText())));
		}
		return button;
	}
	
	
	@FXML
	private void monthBeforeOnAction(ActionEvent event) {
		drawCalendar(Switch.MONTH_MINUS);
	}

	@FXML
	private void nextMonthOnAction(ActionEvent event) {
		drawCalendar(Switch.MONTH_PLUS);
	}

	@FXML
	void yearMinusOnAction(ActionEvent event) {
		drawCalendar(Switch.YEAR_MINUS);
	}

	@FXML
	void yearPlusOnAction(ActionEvent event) {
		drawCalendar(Switch.YEAR_PLUS);
	}

	
	/**
	 * Metoda obs3uguj1ca przycisk "Dodaj notatke" z widoku Calendar
	 * otwieraj1ca wicdok Note.fxml
	 */
	@FXML
	private void addNoteOnAction(ActionEvent event) {
		/**
		 * przekazujemy do klasy Container aktualnie wybran1 date
		 */
		Container container = Container.initContainer();
		container.setLocalDate(localDate.withDayOfMonth(selectedDay));
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getClassLoader().getResource("kalendarz/resources/Note.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = new Stage();
			stage.setTitle("Dodaj notatke " + selectedDateForEvent);
			stage.setScene(scene);
			stage.showAndWait();
			drawTable(selectedDateForEvent);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Medota odpowiedzalna za uzupe3nienie tabeli idTable
	 * @param localDate Przekazujemy aktualnie wybran1 date
	 */
	public void drawTable(LocalDate localDate) {
		List<Note> allContent = noteDao.getAll();
		for (Note ac : allContent) {
			if (ac.getLocalDate().equals(localDate)) {
				observableArrayList.add(new TableNote(ac.getTitle(), ac.getContent()));
			}
		}
		idTitle.setCellValueFactory(new PropertyValueFactory<TableNote, String>("title"));
		idContent.setCellValueFactory(new PropertyValueFactory<TableNote, String>("content"));
		idTable.setItems(observableArrayList);
	}

	
}