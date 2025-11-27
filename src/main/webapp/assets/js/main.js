      const base = '<%= baseUrl %>';
      async function storeError() {
        const body = {
          faultCode: document.getElementById('stowCode').value,
          faultMessage: document.getElementById('stowMessage').value,
          faultService: document.getElementById('stowService').value
        };
        const res = await fetch(base + '/stow', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(body)
        });
        document.getElementById('stowOutput').innerText = await res.text();
      }
      async function retrieveErrors() {
        const count = document.getElementById('retrieveCount').value;
        const res = await fetch(base + '/retrieve?records=' + count);
        document.getElementById('retrieveOutput').innerText = await res.text();
      }
      async function updateError() {
        const body = {
          faultReference: document.getElementById('updateRef').value,
          faultStatus: document.getElementById('updateStatus').value
        };
        const res = await fetch(base + '/overhaul', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(body)
        });
        document.getElementById('updateOutput').innerText = await res.text();
      }