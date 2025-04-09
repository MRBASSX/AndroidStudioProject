# Create a virtual environment
echo "Creating a virtual environment..."
python3.9 -m venv venv
source venv/bin/activate

echo "Installing the latest version of pip..."
python -m pip install --upgrade pip

# Build the project
echo "Building the project..."
python -m pip install -r requirements.txt
python -m pip freeze requirements.txt

# Collect static files
echo "Collecting static files..."
python manage.py collectstatic --noinput 

# Collect migrated Tables
echo "Migrating to database...."
python manage.py migrate


# Production Mode
# vercel --prod