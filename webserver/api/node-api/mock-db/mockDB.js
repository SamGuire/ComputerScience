function sleep(ms) {
  return new Promise((resolve, reject) => {
    setTimeout(() => resolve(), ms);
  });
}

const users = [
  {
    user_id: 1,
    first_name: "Issam",
    last_name: "Robler",
  },
];
export async function getAllUsers() {
  await sleep(3000);
  return users;
}
