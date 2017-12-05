/**
 * 
 */
package sesion3_dome_inicial;

/**
 * @author luismartinezmoreno
 *
 */
public class Book extends Item implements Borrowable{
		private boolean prestado=false;
		private String author;
		public String ISBN;
		public String editorial;
		public Book(String theTitle, String author, String ISBN,String edit)
		{
			super(theTitle);
			if(theTitle==null||author==null||ISBN==null||edit==null)
			{
				throw new RuntimeException("datos no correctos");
			}
			setAuthor(author);
			setISBN(ISBN);
			setEditorial(edit);
		}
		/**
		 * Getter autor
		 * @return
		 */
		public String getAuthor() {
			return author;
		}
		/**
		 * Setter autor
		 * @param author
		 */
		public void setAuthor(String author) {
			this.author = author;
		}
		/**
		 * getter isbn
		 * @return
		 */
		public String getISBN() {
			return ISBN;
		}
		/**
		 * Setter isbn
		 * @param ISBN
		 */
		public void setISBN(String ISBN) {
			this.ISBN = ISBN;
		}
		/**
		 * 
		 * @return
		 */
		public String getEditorial() {
			return editorial;
		}
		public void setEditorial(String editorial) {
			this.editorial = editorial;
		}
		

		public String getResponsable()
		{
			return getAuthor();
		}
		
		
		public boolean isPrestado() {
			return prestado;
		}
		public void setPrestado(boolean prestado) {
			this.prestado = prestado;
		}
		public String toString() 
		{
			String cad="";
			cad+=super.getTitle() + " (" + getISBN() + " ISBN)";
			if (getOwn()) {
				cad+="*";
			} else {
				cad+="\n";
			}
			cad+=getAuthor();
			cad+=getEditorial();
			cad+=getComment();
			
			return cad;
		}
		@Override
		public void setBasePrice() {
			
		}
		@Override
		public void prestar() {
			if(prestado==false)
			{
				setPrestado(true);
			}
			
		}
		@Override
		public void devolver() {
			if(prestado==true)
			{
				setPrestado(false);
			}
			
		}
}
