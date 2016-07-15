package com.shdev.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

/**
 * According to http://tcllib.sourceforge.net/doc/csv.html#SECTid1405
 * The format of regular CSV files is specified as
 * 1. Each record of a csv file (comma-separated values, as exported e.g. by Excel) is a set of ASCII values separated by ",". For other languages it may be ";" however, although this is not important for this case as the functions provided here allow any separator character.
 * 2. If and only if a value contains itself the separator ",", then it (the value) has to be put between "". If the value does not contain the separator character then quoting is optional.
 * 3. If a value contains the character ", that character is represented by "".
 * 4. The output string "" represents the value ". In other words, it is assumed that it was created through rule 3, and only this rule, i.e. that the value was not quoted.
 */
public class CsvObject extends ExcelObject implements Serializable {

    private static final Log LOG = LogFactory.getLog(CsvObject.class);

    public CsvObject(String file_name, String sheet_name, String template_name) throws Exception {
        super(file_name, sheet_name, template_name);
    }

    /**
     * For CSV this is a no-op since the actual write takes place in insertTableAtAnchor
     *
     * @throws Exception
     */
    public void save() throws Exception {
    }

    /**
     * Copy a sql query into a file in CSV format.
     *
     * @param table
     * @param anchorString
     * @param rowLimit
     * @param colLimit
     * @throws Exception
     */
    public void insertTableAtAnchor(String tableUri, String anchorString, int rowLimit, int colLimit) throws Exception {

        FileWriter fw = null;

        Anchor anchor = new Anchor(anchorString);
        int rowIndex = anchor.getRowIndex() - 1;
        int columnIndex = anchor.getColIndex() - 1;

        LOG.info("CSV: anchor=" + anchorString + ";rowIndex=" + rowIndex + ";colIndex=" + columnIndex
                + ";rowLimit=" + rowLimit + ";colLimit=" + colLimit);


        try {
            fw = new FileWriter(this.getFileName());

            // put blank lines at top
            for (int ii = 0; ii < rowIndex; ii++) {
                fw.write("\n");
            }

            int maxRows = rowLimit;
            Object object;


            skipColumns(columnIndex, fw);

            fw.write("\n");

            int countRow = 0;
            int countCol = 0;

            LOG.info("CSV: Inserted " + countRow + " rows of " + rowLimit
                    + ";sheet=" + getSheetName()
                    + ";colLimit=" + colLimit
                    + ";cells=" + countCol);
        } finally {
//			Closer.close(fw);
        }
    }

    /**
     * Put in empty columns to mimic anchor position.  So if Anchor is A4 then each line will
     * start with 3 commas.
     *
     * @param columnIndex
     * @param fw
     * @throws IOException
     */
    private void skipColumns(int columnIndex, FileWriter fw) throws IOException {
        for (int colSkip = 1; colSkip < columnIndex; colSkip++) {
            fw.write(",");
        }
    }

    /**
     * Format an object for CSV.  Essentially this means replacing all " with ""
     * and wrapping the string in quotes if it contains an embedded comma.  Also if the object
     * is null the string is replaced with the text "null".
     *
     * @param object
     * @return CSV formatted string
     */
    public String formatObject(Object object) {
        String ret;

        if (null != object) {
            String tmp = object.toString();
            int quoteIndex = tmp.indexOf('\"');
            int commaIndex = tmp.indexOf(',');
            if (quoteIndex >= 0) {
                tmp = tmp.replaceAll("\"", "\"\"");
            }
            if (commaIndex >= 0 || (quoteIndex >= 0 && tmp.length() > 2)) {
                ret = "\"" + tmp + "\"";
            } else
                ret = tmp;
        } else
            ret = "null";

        return ret;
    }
}
