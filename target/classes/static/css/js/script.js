document.addEventListener('DOMContentLoaded', function() {
    // Add any client-side functionality here
    console.log('Employee Management System loaded');

    // Example: Confirm before deleting
    const deleteButtons = document.querySelectorAll('.btn.delete');
    deleteButtons.forEach(button => {
        button.addEventListener('click', function(e) {
            if (!confirm('Are you sure you want to delete this item?')) {
                e.preventDefault();
            }
        });
    });
});