package db61b;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestTable {
	
	@Test
	public void testTable() {
		Table t = new Table(new String[]{"SID", "Name", "Grade", "Year"});
		assertEquals(4, t.columns());

		assertEquals("SID", t.getTitle(0));

		assertEquals(0, t.findColumn("SID"));
		assertEquals(-1, t.findColumn("Last"));

		assertEquals(true, t.add(new Row(new String[]{"101", "Chris", "B", "Freshmen"})));
		assertEquals(false, t.add(new Row(new String[]{"101", "Chris", "B", "Freshmen"})));
	}

	@Test
	public void testprint() {
		Table t = new Table(new String[]{"SID", "Name", "Grade", "Year"});
		t.add(new Row(new String[]{"101", "Chris", "B", "Freshmen"}));
		t.add(new Row(new String[]{"102", "Ryan", "C", "Sophomore"}));
		t.add(new Row(new String[]{"103", "Bill", "B", "Freshmen"}));
		t.print();
	}

	@Test
	public void testSelect() {
		Table t = new Table(new String[]{"SID", "Name", "Grade", "Year"});
		t.add(new Row(new String[]{"101", "Chris", "B", "Freshmen"}));
		t.add(new Row(new String[]{"102", "Ryan", "C", "Sophomore"}));
		t.add(new Row(new String[]{"103", "Bill", "B", "Freshmen"}));
		
		List<String> l1 = new ArrayList<String>();
		l1.add("SID");
		l1.add("Name");
		
		Table fin = t.select(l1, null);
		System.out.println("TESTSELECT");
		fin.print();
	}

	public static void main(String[] args) {
        System.exit(ucb.junit.textui.runClasses(TestTable.class));
    }

}
