'use-strict'

window.onload = function() {
	let max, min, avg = 0;
	let isApiReturned = false;

	let before = document.querySelector('.before-result-container');
	let after = document.querySelector('.after-result-container');
	let loading = document.querySelector('.loading-container');
	let excuteBtn = document.querySelector('.excute-btn');
	let reExcuteBtn = document.querySelector('.re-excute-btn');


	const showLoading = (isApiReturned, delay) => {
		before.style.display = "none";
		after.style.display = "none";
		loading.style.display = "block";

		setTimeout(() => {
			if (isApiReturned) {
				after.style.display = "block";
				loading.style.display = "none";
			}
		}, delay)
	}


	const apiConnect = async () => {
		await axios.get('http://localhost:8080/click').then(response => {
			console.log(response);
		})
	}

	excuteBtn.addEventListener("click", () => {

		// isApiReturned = true;
		// showLoading(isApiReturned, 5000);

		apiConnect();

	})
}