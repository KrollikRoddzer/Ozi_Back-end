const selectImage = document.querySelector('.select-image');
const inputFile = document.querySelector('#file');
const imgArea = document.querySelector('div.img-area');

selectImage.addEventListener('click', function () {
	inputFile.click();
})

inputFile.addEventListener('change', function () {
	const image = this.files[0]
	const reader = new FileReader();
	reader.onload = ()=> {
		const allImg = imgArea.querySelectorAll('div.img-area');
		allImg.forEach(item=> item.remove());
		const imgUrl = reader.result;
		const img = document.createElement('img');
		img.src = imgUrl;
		imgArea.appendChild(img);
		imgArea.classList.add('active');
		imgArea.dataset.img = image.name;
	}
		reader.readAsDataURL(image);
})
function myFunction() { 
    var x = document.getElementById("password");
    var y = document.getElementById("password2");
         if (x.type === "password") {
            x.type = "text";
            y.type = "text";
        } 
     else {      
         x.type = "password"; 
         y.type = "password";        
        }      
}



