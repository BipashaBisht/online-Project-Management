async function createUser(e) {
  e.preventDefault();
  const name = document.getElementById('name').value;
  const email = document.getElementById('email').value;

  const res = await fetch('/api/users', {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify({name, email})
  });
  const data = await res.json();
  document.getElementById('createResult').innerText = 'Created user with ID: ' + data.id;
}

async function loadUsers() {
  const res = await fetch('/api/users');
  const users = await res.json();
  const ul = document.getElementById('usersList');
  ul.innerHTML = '';
  users.forEach(u => {
    const li = document.createElement('li');
    li.innerText = `${u.id} - ${u.name} (${u.email})`;
    ul.appendChild(li);
  });
}

document.getElementById('userForm').addEventListener('submit', createUser);
document.getElementById('loadUsers').addEventListener('click', loadUsers);
