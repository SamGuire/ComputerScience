import fetch from "node-fetch";
const time = [];
const timelineURL = "http://127.0.0.1:3000/timeline";
const responsesInMS = [];
const fetchRequests = [];
function random_number(max_possible_user_id) {
  return Math.floor(Math.random() * max_possible_user_id);
}

async function makeCall() {
  let start = new Date();
  await fetch(`${timelineURL}/${random_number(10000)}`);
  let end = new Date();
  responsesInMS.push(end - start);
}

function makeCalls(numberOfCalls) {
  for (let _ = 0; _ < numberOfCalls; _++) {
    fetchRequests.push(makeCall());
  }
  console.log("Sent all requests, awaiting results...");
}

(async function () {
  const numberOfCalls = Number.parseInt(process.argv[2]);
  if (!numberOfCalls) {
    console.log("Please supply an integer");
  } else {
    makeCalls(numberOfCalls);
    await Promise.all(fetchRequests).then(() => {
      const size = responsesInMS.length;
      console.log(`Number of responses = ${size}`);
      responsesInMS.sort((a, b) => a - b);
      console.log(`Median = ${responsesInMS[size / 2]}`);
      console.log(`Max = ${responsesInMS[size - 1]}`);
    });
  }
})();
