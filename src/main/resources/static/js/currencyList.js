document.addEventListener('DOMContentLoaded', function() {
  let currencyDropdowns = document.querySelectorAll('.currency');

  currencyDropdowns.forEach(dropdown => {
    dropdown.addEventListener('change', function() {
      let selectedCurrency = this.value;
      let offerElement = this.closest('.offer');
      let amountInBGN = offerElement.querySelector('.priceInBGN').value;
      let priceSpan = offerElement.querySelector('.price');

      fetch('/api/convert?' + new URLSearchParams({
        from: 'BGN',
        to: selectedCurrency,
        amount: amountInBGN
      }))
      .then(response => response.json())
      .then(data => {
        priceSpan.textContent = data.result;
      })
      .catch(error => {
        console.log('An error occurred: ' + error);
      });
    });
  });
});