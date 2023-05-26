import { MOCK_EMPLOYEE_DATA } from "./mock-data.js";

/**
 *
 * @param {Number} ms
 * @returns {Promise<void>}
 * @description Sleep for 'ms' milliseconds
 */
async function sleep(ms) {
  return new Promise((resolve, _) => {
    setTimeout(() => resolve(), ms);
  });
}

/**
 * @returns {Promise<{name:string,position:string,salary:number}[]>}
 * @description Get all employees from 'DB'
 */
export async function getAllEmployee() {
  await sleep(3000);
  return MOCK_EMPLOYEE_DATA;
}
