package com.bench.shoppingcart.service;

import com.bench.shoppingcart.domain.Item;
import com.bench.shoppingcart.domain.ItemType;
import com.bench.shoppingcart.exception.ItemNotFoundException;
import com.bench.shoppingcart.repository.CartRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public Item add(Item item) {
        Item savedItem = cartRepository.save(item);
        savedItem.setName("item_saved");
        return savedItem;
    }

    public List<Item> getAll() {
        return cartRepository.findAll();
    }

    public void deleteById(Long id) {
        Optional<Item> item = cartRepository.findById(id);
        if (item.isPresent()) {
            cartRepository.deleteById(id);
        } else {
            throw new ItemNotFoundException();
        }
    }

    public void excelReader() throws Exception {
        List<Item> listItem = new ArrayList();

        try {

            File file = new File("src/main/resources/ITEMS.xlsx");
            //creating a new file instance
            FileInputStream fis = new FileInputStream(file);
            //obtaining bytes from the file
            //creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            //creating a Sheet object to retrieve object
            Iterator<Row> itr = sheet.iterator();
            //iterating over excel file
            System.out.println("This is the given file");
            int rowCount = 0;
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                Item item = new Item();
                //iterating over each column
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            //field that represents string cell type
                            if (cell.getStringCellValue()
                                    .equalsIgnoreCase(String.valueOf(ItemType.DRESSES))
                                    || cell.getStringCellValue()
                                    .equalsIgnoreCase(String.valueOf(ItemType.SHOES))
                                    || cell.getStringCellValue()
                                    .equalsIgnoreCase(String.valueOf(ItemType.SPORTS))) {
                                item.setType(ItemType.valueOf(cell.getStringCellValue()));
                            } else {
                                item.setName(cell.getStringCellValue());
                            }
                            //System.out.print(cell.getStringCellValue() + "\t\t\t");
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            //field that represents number cell type
                            if (cell.getColumnIndex() == 0)
                                item.setId((long) cell.getNumericCellValue());
                            else
                                item.setPrice(cell.getNumericCellValue());

                            //System.out.print(cell.getNumericCellValue() + "\t\t\t");
                            break;
                        default:
                    }
                }
                //System.out.println("");
                System.out.println("Item: " + item.toString());
                listItem.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
