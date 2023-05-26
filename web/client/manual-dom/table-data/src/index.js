import { getAllEmployee } from "./api/api.js";
var employeeData = null;
var IS_ASC = true;
/**
 *
 * @param {Object[]} dataList
 * @param {string} sortByKey
 * @returns
 * @description Sort list of objects by property 'sortByKey'
 */
function sortData(dataList, sortByKey) {
  dataList.sort((a, b) => {
    if (a[sortByKey] > b[sortByKey]) {
      return IS_ASC ? 1 : -1;
    } else if (a[sortByKey] == b[sortByKey]) {
      return 0;
    } else {
      return IS_ASC ? -1 : 1;
    }
  });
}
/**
 *
 * @param {string[]} columnNameList
 * @returns {HTMLTableRowElement} Header row for data table
 * @description Transforms a list of strings to a table header row
 */
function constructHeaderRow(columnNameList) {
  const tRow = document.createElement("tr");
  columnNameList.forEach((element) => {
    // Create cell
    const tHCell = document.createElement("th");
    tHCell.innerText = element;
    tHCell.addEventListener("click", (evt) => {
      evt.preventDefault();
      sortData(employeeData, element);
      IS_ASC = !IS_ASC;
      const tDataRows = constructListOfDOMTableRows(employeeData);
      const tBody = document.getElementsByClassName("data-table-body")[0];
      tBody.replaceChildren(...tDataRows);
    });

    // attach to row
    tRow.appendChild(tHCell);
  });
  return tRow;
}

/**
 *
 * @param {Object} data
 * @returns {HTMLTableRowElement} DOM 'tr' elements representing rows of for a 'table' element
 * @description Transform object list of data to suitable tr elements for a table
 */
function transformDataToTableRow(data) {
  const tRow = document.createElement("tr");
  for (const property in data) {
    const tdCell = document.createElement("td");
    tdCell.innerText = data[property];
    tRow.appendChild(tdCell);
  }
  return tRow;
}

/**
 *
 * @param {Object[]} dataList
 * @returns {HTMLTableRowElement[]} List of DOM 'tr' elements representing rows of for a 'table' element
 * @description returns object list of data to list of tr elements for a table
 */
function constructListOfDOMTableRows(dataList) {
  if (dataList.length <= 0) return [];
  return dataList.map(transformDataToTableRow);
}

/**
 *
 * @returns
 * @description Initalize HTML view
 */
async function init() {
  employeeData = await getAllEmployee();
  if (employeeData.length <= 0) {
    console.error("Employee data not found!");
    return;
  }
  const tHeaderRow = constructHeaderRow(Object.keys(employeeData[0]));
  const tHead = document.getElementsByClassName("data-table-head")[0];
  tHead.appendChild(tHeaderRow);

  const tDataRows = constructListOfDOMTableRows(employeeData);
  const tBody = document.getElementsByClassName("data-table-body")[0];
  tBody.replaceChildren(...tDataRows);
}

init();
