// Import Libraries
import { Observable } from 'rxjs/Rx';
import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from "@angular/material";
import { ModalRemoveComponent } from '../../components/modal-remove.component';


// Import Services
import { AssetService } from '../../services/asset.service';

// Import Models
import { Asset } from '../../domain/test2_db/asset';
import { User } from '../../domain/test2_db/user';
// START - USED SERVICES
/*
 *	assetService.delete
 *		PARAMS: 
 *					ObjectId id - Id
 *		
 *
 *	assetService.list
 *		PARAMS: 
 *		
 *
 */
// END - USED SERVICES

// START - REQUIRED RESOURCES
/*
 * assetService  
 */
// END - REQUIRED RESOURCES

@Component({
    selector: "asset-list",
    templateUrl: './asset-list.component.html',
    styleUrls: ['./asset-list.component.css']
})
export class AssetListComponent implements OnInit {
    
    // Attributes
    list: Asset[];
    search: any = {};
    idSelected: string;
    
    // Constructor
    constructor(
        private assetService: AssetService, 
        public dialog: MatDialog) {}

    // Functions
    ngOnInit(): void {
        this.assetService.list().subscribe(list => this.list = list);
    }

    openModal(id: string): void {
        let dialogRef = this.dialog.open(ModalRemoveComponent, {
            width: '250px',
            data: () => {
                // Execute on confirm
                this.assetService.remove(id).subscribe(() => {
                    dialogRef.close();
                });
                this.list = this.list.filter(item => item._id != id);
            }
        });
    }

}