'use-strict'

window.onload = function() {
	let max, avg, min = 0;

	const before = document.querySelector('.before-result-container');
	const after = document.querySelector('.after-result-container');
	const loading = document.querySelector('.loading-container');
	const excuteBtn = document.querySelector('.excute-btn');
	const reExcuteBtn = document.querySelector('.re-excute-btn');
	
	const maxSpan = document.querySelector('.max');
	const avgSpan = document.querySelector('.avg');
	const minSpan = document.querySelector('.min');


	const showLoading = () => {
		before.style.display = "none";
		after.style.display = "none";
		loading.style.display = "block";
	}

	const showResult = () => {
		after.style.display = "block";
		loading.style.display = "none";
	}


	const apiConnect = async () => {
		showLoading();
		try {
			await axios.get('http://localhost:8080/click').then(response => {
				max = response.data.max.toString().slice(0, 6);
				min = response.data.min;
				avg = response.data.avg;
				
				maxSpan.innerText = max + "ms";
				avgSpan.innerText = avg + "ms";
				minSpan.innerText = min + "ms";
				
			})
		}
		catch (e) { console.log(e); }
		finally { showResult(); }
	}


	excuteBtn.addEventListener("click", () => {
		apiConnect();
	})
	
	reExcuteBtn.addEventListener("click", () => {
		apiConnect();
	})
}