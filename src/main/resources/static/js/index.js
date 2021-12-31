'use-strict'

window.onload = function () {
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

    excuteBtn.addEventListener("click", () => {

        isApiReturned = true;
        showLoading(isApiReturned, 5000);

        // loading.style.display = "none";
        // after.style.display = "block";

    })
    
    reExcuteBtn.addEventListener("click", ()=> {
		max, min, avg = 0;
		
        before.style.display = "block";
        after.style.display = "none";
        loading.style.display = "none";

	})
}